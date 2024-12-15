const EventEmitter = require('events');
const event = new EventEmitter();

event.on('event1',(a,b)=>{
    let res = a*b;
    console.log("mul res",res);
})

event.emit('event1',10,10);