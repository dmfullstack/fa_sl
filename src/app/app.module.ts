import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { SearchresponseComponent } from './searchresponse/searchresponse.component';
import { AppRoutingModule} from './app-routing.module';
import { FavouritesComponent } from './favourites/favourites.component';
import { RestaurantDetailComponent } from './restaurant-detail/restaurant-detail.component';
import { HomeComponent } from './home/home.component';
export const myComponents = [
  AppComponent
];

@NgModule({
  declarations: [
    ...myComponents,
    SearchresponseComponent,
    FavouritesComponent,
    RestaurantDetailComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
