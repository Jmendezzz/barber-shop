import express from "express";

const app = express();
const PORT = 8000;

app.use(express.json());

app.listen(PORT,()=>{

    console.log('Running server on port:' + PORT);

})