import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SearchresponseComponent } from './searchresponse/searchresponse.component';
import { HomeComponent } from './home/home.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { RestaurantDetailComponent } from './restaurant-detail/restaurant-detail.component';


const routes: Routes = [
  { path: 'search', component: SearchresponseComponent },
  { path: 'home', component: HomeComponent },
  { path: 'favourites', component: FavouritesComponent },
  { path: 'resdetail/:id', component: RestaurantDetailComponent },
  { path: '', redirectTo: '/search', pathMatch: 'full' }

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
