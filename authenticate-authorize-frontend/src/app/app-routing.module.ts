import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { ListCutomersComponent } from './list-cutomers/list-cutomers.component';


const routes: Routes = [

  { path: 'app-home', component: HomeComponent },
  {
    path: 'app-authenticate', component:AuthenticateComponent
  },
  {
    path:'list-customers',component:ListCutomersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
