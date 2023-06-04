
const { defineConfig } = require('@vue/cli-service')
const dotenv = require('dotenv');

module.exports = defineConfig({

  dotenv.config();
  transpileDependencies: true

})
