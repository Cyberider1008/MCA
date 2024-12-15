const http = require('http');


http.createServer((req,res) => {

res.write("this is from core module");
res.end();

}).listen(5000);