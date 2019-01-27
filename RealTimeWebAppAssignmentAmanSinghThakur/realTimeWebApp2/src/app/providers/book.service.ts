import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class BookService {
  constructor(private http: HttpClient) {}
  getBookById(id): Observable<any> {
    console.log("realtimewebappSpring/books/" + id + "/get");
    return this.http.get("realtimewebappSpring/books/" + id + "/get");
  }
  getAllBooks(): Observable<any> {
    return this.http.get("realtimewebappSpring/books");
  }
  addBook(book: any): Observable<any> {
    return this.http.post("realtimewebappSpring/books", book);
  }
  checkoutBook(checkout: any): Observable<any> {
    console.log(checkout);
    return this.http.post("realtimewebappSpring/checkoutBook/", checkout);
  }
  getAllCheckoutBooks(): Observable<any> {
    return this.http.get("realtimewebappSpring/checkoutBooks");
  }
}
