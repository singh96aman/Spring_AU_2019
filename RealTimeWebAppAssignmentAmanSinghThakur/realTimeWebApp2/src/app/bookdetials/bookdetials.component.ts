import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/providers/book.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-bookdetials",
  templateUrl: "./bookdetials.component.html",
  styleUrls: ["./bookdetials.component.scss"]
})
export class BookdetialsComponent implements OnInit {
  id: string;
  book: any[];

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get("id");
    this.bookService.getBookById(this.id).subscribe(response => {
      if (response) {
        this.book = response;
      }
    });
  }
}
