import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTerminalFormComponent } from './add-terminal-form.component';

describe('AddTerminalFormComponent', () => {
  let component: AddTerminalFormComponent;
  let fixture: ComponentFixture<AddTerminalFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTerminalFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTerminalFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
