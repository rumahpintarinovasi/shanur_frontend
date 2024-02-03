import axios from "axios";

export default defineNuxtPlugin((nuxtApp) => {
  const defaultUrl = "https://jsonplaceholder.typicode.com";

  let api = axios.create({
    baseURL: defaultUrl,  // Corrected property name to baseURL
    headers: {
      Authorization: `Bearer ${localStorage.getItem("token")}`,
    },
  });

  return {
    provide: {
      api: api,
    },
  };
});
