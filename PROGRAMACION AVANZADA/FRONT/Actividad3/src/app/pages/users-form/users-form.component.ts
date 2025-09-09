import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { UsersService } from '../../services/users.service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { User } from '../../interfaces/user';

@Component({
  selector: 'app-users-form',
  imports: [ReactiveFormsModule,RouterLink],
  templateUrl: './users-form.component.html',
  styleUrl: './users-form.component.css'
})
export class UsersFormComponent {

  router = inject(Router);
  usersService = inject(UsersService);
  activatedRoute = inject(ActivatedRoute);

  usersForm: FormGroup;
  tipo: string;

  constructor() {
    this.tipo = "Insertar";

    this.usersForm = new FormGroup({
      first_name: new FormControl('', [Validators.required]),
      last_name: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    },
      []);
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async (params: any) => {
      if (params._id) {
        this.tipo = "Actualizar"
        //peticion al servicio getById
        const userResponse : User = await this.usersService.getById(params._id);

        this.usersForm = new FormGroup({
          _id: new FormControl(userResponse._id, []),
          first_name: new FormControl(userResponse.first_name, [Validators.required]),
          last_name: new FormControl(userResponse.last_name, [Validators.required]),
          username: new FormControl(userResponse.username, [Validators.required]),
          email: new FormControl(userResponse.email, [Validators.required]),
          image: new FormControl(userResponse.image, [Validators.required]),
          password: new FormControl(userResponse.password,[Validators.required])
        }, []);
      }

    });
  }

  async getDataForm() {
    if (this.usersForm.valid) {
      try {
        
        const formValue: User = this.usersForm.value;

        if (this.tipo === 'Actualizar') {
          
          await this.usersService.update(formValue);
          alert('Usuario actualizado correctamente (mock)');
        } else {
          
          await this.usersService.insert(formValue);
          alert('Usuario creado correctamente (mock)');
        }

        
        this.router.navigate(['/home']);

      } catch (err) {
        console.error('Error al guardar usuario =>', err);
        alert('Error al ' + (this.tipo === 'Actualizar' ? 'actualizar' : 'crear') + ' usuario');
      }
    } else {
      
      alert('Por favor, rellena todos los campos');
    }
  }
}