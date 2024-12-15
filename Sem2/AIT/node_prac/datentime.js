function datetime(){
    const dt = new Date();


    let date = ('0'+ dt.getDate()).slice(-2);

    let month = ('0'+ (dt.getMonth()+1)).slice(-2);

    let year = dt.getFullYear();


    let hours = dt.getHours();

    let minutes = dt.getMinutes();

    let seconds = dt.getSeconds();


    return date+"-"+month+"-"+ year+" "+hours+":"+minutes+":"+seconds;

}

console.log(datetime());