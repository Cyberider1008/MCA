const http = require('http');
const url = require('url');


http.createServer((req,resp)=>{
    const Parsedurl = url.parse(req.url , true);

    const query = Parsedurl.query;

    console.log(query);

    resp.write("he");
    resp.end();

}).listen(5000);


