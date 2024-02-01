// create useFetch nuxt 3 extend that can be used in any component tht include authorization bearer token from localStorage and can choose method and choose the endpoint baseurl jsonplaceholder
export const useApi = (endpoint, method, body) => {

  const { data, error, loading } = useFetch(
    `https://jsonplaceholder.typicode.com/${endpoint}`,
    {
      method,
      body,
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    }
  );

  return { data, error, loading };
};
