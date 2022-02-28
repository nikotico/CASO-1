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

async function main() {
    /*
        Consultas https://www.prisma.io/docs/reference/api-reference/prisma-client-reference#prismaclient
        los objetos tiene que llarse en minuscula
   */

    let prisma1 = new PrismaClient()
    let prisma2 = new PrismaClient()
    let prisma3 = new PrismaClient()
    let prisma4 = new PrismaClient()
    let prisma5 = new PrismaClient()
    let prisma6 = new PrismaClient()
    let prisma7 = new PrismaClient()
    let prisma8 = new PrismaClient()
    let prisma9 = new PrismaClient()
    let prisma10 = new PrismaClient()
    let prisma11 = new PrismaClient()

    //const dc = await prisma.delivPerCant.canton.findMany();

    const sql = await prisma11.delivPerCant.findMany({
        select: {
            id: false,
            deli_id: false,
            canton_id: false,
            Canton: true,
            Deliverable: {
                select: {
                    Action: {
                        select: {
                            name: true
                        }//Fin select
                    },
                    Userr: {
                        select: {
                            Party: {
                                select: {
                                    name: true
                                }//Fin select
                            },
                        }//Fin select
                    },
                }//Fin select deliver
            },
        }

    })

    const result = await prisma11.$queryRaw `SELECT * FROM qr3Max`
    console.log(result)

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
