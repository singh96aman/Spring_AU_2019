import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomePageComponent } from "./component/home-page/home-page.component";
import { SearchComponent } from "./component/search/search.component";
import { BookdetialsComponent } from "./bookdetials/bookdetials.component";
import { CheckoutComponent } from "./component/checkout/checkout.component";

const routes: Routes = [
  { path: "home-page", component: HomePageComponent },
  // { path: "", redirectTo: "/home", pathMatch: "full" }
  { path: "search", component: SearchComponent },
  { path: "book/:id", component: BookdetialsComponent },
  { path: "checkout", component: CheckoutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
