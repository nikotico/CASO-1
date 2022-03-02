const sql = require('mssql');

const sqlConfig = {
    server: 'NIKOF',
    port: 1433,
    user: "sa",
    password: "admin",
    database: "aseni",
    pool: {//Aqui hago los ajustes de los pooling
        max: 10,
        min: 2,
        idleTimeoutMillis: 30000
    },
    options: {
        trustServerCertificate: true,
        enableArithAbort: true
    }
}
/*
sql.on('error', err => {
    console.log(err.message)
})
*/

async function consulta() {
    try {
        // make sure that any items are correctly URL encoded in the connection string
        let pool = await sql.connect(sqlConfig)
        let result = await pool.request().query('exec qr2')
        console.dir(result)
    } catch (err) {
        console.dir(err)
    }
}

console.time('loop');


for (var i = 0; i <= 9; i++) {
    consulta() 

}
console.timeEnd('loop');
/*
Tiempo de ejecucion
loop: 11.322ms
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Canton: 'Grecia
                                                                                                   ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1, 1 ]
}
*/
// C:\Users\fgm_o\Documentos\TEC\5 Semestre\Bases ll\Caso #1\typescript\qr1v2>