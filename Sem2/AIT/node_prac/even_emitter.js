const EventEmitters = require('events');
const event = new EventEmitters();

const express = require('express');
const app = express();


event.on('emit1',() =>{
    console.log("this is first event");
})

app.get('/',(req,res)=>{
    res.send("this is home page");
    event.emit('emit1');
});

app.listen(5000);