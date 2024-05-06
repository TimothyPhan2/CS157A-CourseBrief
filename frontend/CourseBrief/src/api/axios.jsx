import axios from 'axios';

const axios1 = axios.create({
  baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json'
    },
});

export default axios1;