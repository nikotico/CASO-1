/*
    Antes instalar node.js

    npm init
    npx tsc --init

    Instalacion de sequelize
    https://sequelize.org/master/manual/getting-started.html#installing

    npm i sequelize # This will install latest version of Sequelize
    npm i tedious # Microsoft SQL Server antes crear y configurar el tsconfig.json

    datos importante
        revisar que sql este habilitado el trafico tpc/ip y que el usuario tenga una contrasena correcta
*/
const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('caso1', 'sa', 'admin', {
    host: 'localhost',
    dialect: 'mssql'
});

const User = sequelize.define('Userr', {
  // Model attributes are defined here
  name: true,
});

// `sequelize.define` also returns the model
console.log(User == sequelize.models.User); // true

/*

  Try connection 
  try {
      sequelize.authenticate();
      console.log('Connection has been established successfully.');
    } catch (error) {
      console.error('Unable to connect to the database:', error);
    }


   Try code : Exec in terminal 
   npx ts-node index.ts
 */