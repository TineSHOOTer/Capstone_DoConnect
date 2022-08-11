import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChatService } from './../chat.service';
import { MessageDTO } from '../messageDTO';

import { User } from '../user';
import { UserStorageService } from '../services/storage/user-storage.service';

@Component({
  selector: 'app-chatbox',
  templateUrl: './chatbox.component.html',
  styleUrls: ['./chatbox.component.scss']
})
export class ChatboxComponent implements OnInit {
  mymessage:string[] = []; 
  m:any;
  constructor(private chatService:ChatService , 
    private router:Router,private userStorageService : UserStorageService) { }

  ngOnInit(): void {
    this.user.id=UserStorageService.getUserId();
 
    console.log(this.user.id);
    if (this.user.id=='') {
      console.log(this.user.id);
      alert("Login Required")
      this.router.navigate(['/login'])
    }
  }

  messageDTO= new MessageDTO()
messages:MessageDTO [] | undefined
user= new User()

  sendMessage(m:string) {
   this.messageDTO.fromUser=UserStorageService.getUserName()
    this.messageDTO.message=m

    this.chatService.sendMessage(this.messageDTO).subscribe((data)=>{
      this.messageDTO=data
      this.getMessage()
    })
  }

  getMessage() {
    this.chatService.getMessage().subscribe((data)=>{
      this.messages=data
      console.log(UserStorageService.getUser());
    })


  }
}
