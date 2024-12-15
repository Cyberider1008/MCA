const readline_sync = require('readline-sync')

const question = readline_sync.question("enter your string")


const lower = question.toLowerCase()
console.log(lower);  