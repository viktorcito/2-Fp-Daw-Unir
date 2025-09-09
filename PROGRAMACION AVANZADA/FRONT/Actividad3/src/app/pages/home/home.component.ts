import { Component, inject } from '@angular/core';
import { User } from '../../interfaces/user';
import { UsersService } from '../../services/users.service';
import { UserCardComponent } from "../../components/user-card/user-card.component";


@Component({
  standalone: true,
  selector: 'app-home',
  imports: [UserCardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  arrUsers: User[];
  userService = inject(UsersService);

  constructor() {
    this.arrUsers = [];
  }

  async ngOnInit(): Promise<void> {
    //Usando Observables
      this.userService.getAllWithObservables().subscribe((data) => {
      this.arrUsers = data.results;
     });

    //Usando promesas
  /*  try {
      this.arrUsers = await this.userService.getAllUsers();
    }
    catch (err) {
      console.log('Error al conectar a la API: '+err)
    }
*/    
  }

}