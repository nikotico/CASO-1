/*
    Otro ORM
    https://www.npmjs.com/package/typeorm

    Instalacion de prisma
    https://www.prisma.io/docs/getting-started/setup-prisma/start-from-scratch/relational-databases-typescript-sqlserver
    
    npm init -y
    npm install prisma typescript ts-node @types/node --save-dev

    antes crear y configurar el tsconfig.json
    npx prisma
    npx prisma init
    
    Conectarlo con la base de datos
    https://www.prisma.io/docs/getting-started/setup-prisma/add-to-existing-project/relational-databases-typescript-sqlserver
    
    datos importante
        revisar que sql este habilitado el trafico tpc/ip y que el usuario tenga una contrasena correcta


    pooling
    https://www.prisma.io/docs/concepts/components/prisma-client/working-with-prismaclient/connection-pool

    cache
    https://www.npmjs.com/package/node-ts-cache
*/

import { PrismaClient } from '@prisma/client'

const prisma = new PrismaClient()

function comentarios(){

        /*
      typescript\query3\ts>npx ts-node index.ts
      el pool lo ajusto en .env
      Query 3 MAX 
  [
    {
      Partido: 'PAC
                                                                                                        ',
      Accion: 'Soporte tecnologico con computadoras
                                                                                                       ',
      Canton: 'Alajuela
                                                                                                       ',
      'Cant Kpi Entregables': 96
    },
    {
      Partido: 'PLN
                                                                                                        ',
      Accion: 'Asfaltado o restauracion de las carretera
                                                                                                       ',
      Canton: 'Naranjo
                                                                                                       ',
      'Cant Kpi Entregables': 82
    },
    {
      Partido: 'PSD
                                                                                                        ',
      Accion: 'Plantar arboles en zonas publicas
                                                                                                       ',
      Canton: 'Naranjo
                                                                                                       ',
      'Cant Kpi Entregables': 59
    },
    {
      Partido: 'PUSC
                                                                                                        ',
      Accion: 'Entrega de libros a la diferentes escuelas
                                                                                                       ',
      Canton: 'Naranjo
                                                                                                       ',
      'Cant Kpi Entregables': 92
    }
  ]
  
        Query 3 MIN 
  [
    {
      Partido: 'PAC
                                                                                                        ',
      Accion: 'Soporte tecnologico con computadoras
                                                                                                       ',
      Canton: 'Atenas
                                                                                                       ',
      'Cant Kpi Entregables': 83
    },
    {
      Partido: 'PLN
                                                                                                        ',
      Accion: 'Asfaltado o restauracion de las carretera
                                                                                                       ',
      Canton: 'Alajuela
                                                                                                       ',
      'Cant Kpi Entregables': 53
    },
    {
      Partido: 'PSD
                                                                                                        ',
      Accion: 'Plantar arboles en zonas publicas
                                                                                                       ',
      Canton: 'Grecia
                                                                                                       ',
      'Cant Kpi Entregables': 3
    },
    {
      Partido: 'PUSC
                                                                                                        ',
      Accion: 'Entrega de libros a la diferentes escuelas
                                                                                                       ',
      Canton: 'Atenas
                                                                                                       ',
      'Cant Kpi Entregables': 71
    }
    loop: 60.974ms
  ]
    */
}
async function main() {
    /*
        Consultas https://www.prisma.io/docs/reference/api-reference/prisma-client-reference#prismaclient
        los objetos tiene que llarse en minuscula
   */

    console.time('loop');
    const result = await prisma.$queryRaw`SELECT * FROM qr3Max`
    console.log(result)
    const result2 = await prisma.$queryRaw`SELECT * FROM qr3Min`
    console.log(result2)
    console.timeEnd('loop');
}


main()
    .catch((e) => {
        throw e
    })
    .finally(async () => {
        await prisma.$disconnect()
    })

/*
   Exec in terminal 
   npx ts-node index.ts
 */
