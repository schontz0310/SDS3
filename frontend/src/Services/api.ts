import axios from 'axios';


const api = {
  localApi: axios.create({
    baseURL: 'http://localhost:3333',
  }),
  homolApi: axios.create({
    baseURL: 'http://localhost:3333',
  }), 
  prodApi: axios.create({
    baseURL: 'https://sds3-ags-dsvendas.herokuapp.com',
  }), 
}


export default api;
