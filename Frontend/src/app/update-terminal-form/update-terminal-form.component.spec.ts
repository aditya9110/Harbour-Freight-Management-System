import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTerminalFormComponent } from './update-terminal-form.component';

describe('UpdateTerminalFormComponent', () => {
  let component: UpdateTerminalFormComponent;
  let fixture: ComponentFixture<UpdateTerminalFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTerminalFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTerminalFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
