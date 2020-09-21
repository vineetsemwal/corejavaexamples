import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { SubstringPipe } from './pipes/substring';
import { SmallestPipe } from './pipes/smallest';
import { AddUserComponent } from './add-user/add-user.component';
import { UserService } from './service/userservice';
import { AdduserCodedrivenComponent } from './adduser-codedriven/adduser-codedriven.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserListComponent,
    SubstringPipe,
    SmallestPipe,
    AddUserComponent,
    AdduserCodedrivenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
