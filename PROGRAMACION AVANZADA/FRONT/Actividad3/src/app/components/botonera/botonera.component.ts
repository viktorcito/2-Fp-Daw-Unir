import { Component, inject, Input } from '@angular/core';
import { UsersService } from '../../services/users.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-botonera',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './botonera.component.html',
  styleUrl: './botonera.component.css'
})
export class BotoneraComponent {

  usersService = inject(UsersService);
  router = inject(Router);

  @Input() _id: string;
  @Input() parent: string;


  constructor() {
    this._id = "";
    this.parent = "";
  }

  async borrarUser(_id: string) {
    let confirmacion = confirm(' Esta seguro de que quiere eliminar lel susuario: ' + this._id);
    if (confirmacion) {
      let response = await this.usersService.delete(_id);
      //Esto es particular de la API
      if (response._id) {
        alert('Se ha borrado correctamente el usuario ' + response.first_name);
        if (this.parent == 'view') {
          this.router.navigate(['/home']);
        }
        else if(this.parent == "card" ){
          location.reload();
        }
      }
    }
    
  }


}
