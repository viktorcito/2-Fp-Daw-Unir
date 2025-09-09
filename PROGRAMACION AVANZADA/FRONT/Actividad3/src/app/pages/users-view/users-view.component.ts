import { Component, inject } from '@angular/core';
import { UsersService } from '../../services/users.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../interfaces/user';
import { BotoneraComponent } from "../../components/botonera/botonera.component";

@Component({
  selector: 'app-users-view',
  standalone: true,
  imports: [BotoneraComponent],
  templateUrl: './users-view.component.html',
  styleUrl: './users-view.component.css'
})
export class UsersViewComponent {

  usersService = inject(UsersService);
  activatedRoute = inject(ActivatedRoute);

  miUser!: User;

  ngOnInit(): void{
    this.activatedRoute.params.subscribe(async (params: any) => {
      let _id: string = params._id as string;

      try {
        this.miUser = await this.usersService.getById(_id);
      } catch (err) {
        console.log("Error al llamar a la API: " + err);
      }
    });
  }
}
