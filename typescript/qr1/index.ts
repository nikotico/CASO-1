const sql = require('mssql');

const sqlConfig = {
  server: 'NIKOF',
  port: 1433,
  user: "sa",
  password: "admin",
  database: "aseni",
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
async function consulta(canton) {
  try {
    // make sure that any items are correctly URL encoded in the connection string
    await sql.connect(sqlConfig)
    let result = await sql.query('exec qr1 @canton = ' + canton)

    console.dir(result)
  } catch (err) {
    console.dir(err)
  }
}


var cantones = ["Alajuela", "Atenas", "Naranjo", "Grecia"]

console.time('loop');

for (var i = 0; i <= 9; i++) {
  let canton = cantones[Math.floor(Math.random() * 4)]
  console.log(canton)
  consulta(canton)
}
console.timeEnd('loop');


/*
Tiempo de ejecucion
loop: 14.746ms

Grecia
Naranjo
Grecia
Grecia
Grecia
Atenas
Atenas
Atenas
Alajuela
Atenas
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1 ]
}
{
  recordsets: [ [ [Object] ] ],
  recordset: [
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 1 ]
}
{
  recordsets: [ [ [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PUSC
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 3 ]
}
{
  recordsets: [ [ [Object], [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PUSC
                                                                                                    ',
      Entregables: 2
    }
  ],
  output: {},
  rowsAffected: [ 4 ]
}
{
  recordsets: [ [ [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PUSC
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 3 ]
}
{
  recordsets: [ [ [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PUSC
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 3 ]
}
{
  recordsets: [ [ [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PSD
                                                                                                    ',
      Entregables: 2
    }
  ],
  output: {},
  rowsAffected: [ 3 ]
}
{
  recordsets: [ [ [Object], [Object], [Object] ] ],
  recordset: [
    {
      Partido: 'PAC
                                                                                                    ',
      Entregables: 1
    },
    {
      Partido: 'PLN
                                                                                                    ',
      Entregables: 2
    },
    {
      Partido: 'PUSC
                                                                                                    ',
      Entregables: 1
    }
  ],
  output: {},
  rowsAffected: [ 3 ]
}
}
*/