// plugins/axios.js
import axios from 'axios';

export default function ({ app }, inject) {
  const axiosInstance = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com', // Replace with your API base URL
  });

  inject('axios', axiosInstance);
}
