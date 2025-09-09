import { Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { UsersFormComponent } from './pages/users-form/users-form.component';
import { UsersViewComponent } from './pages/users-view/users-view.component';


export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent }, // esto seria mi userList
  { path: "nueva/user", component: UsersFormComponent },
  { path: "user/:_id", component: UsersViewComponent},
  { path: "actualizar/user/:_id", component: UsersFormComponent},
  {path: "**", redirectTo: "home"}
];
