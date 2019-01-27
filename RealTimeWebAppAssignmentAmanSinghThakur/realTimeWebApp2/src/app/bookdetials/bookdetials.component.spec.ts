import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookdetialsComponent } from './bookdetials.component';

describe('BookdetialsComponent', () => {
  let component: BookdetialsComponent;
  let fixture: ComponentFixture<BookdetialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookdetialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookdetialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
