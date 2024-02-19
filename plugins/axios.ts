import axios, { type AxiosRequestConfig, type AxiosInstance, type AxiosResponse } from 'axios';

interface axiosPayload {
  method: string,
  url: string,
  data?: any,
  config?: AxiosRequestConfig,
  isAuth?: boolean,
  params : Object
}

interface pluginResponse {
  provide : any
}
export default defineNuxtPlugin (()  => {
  const config = useRuntimeConfig()
  const defaultUrl:string = config.public.BASE_URL_BACKEND || "http://localhost:4000/api/v1"
  const restAPI :AxiosInstance = axios.create({
    baseURL: defaultUrl,
    headers: {
      Accept: "application/json",
    },
  })

  async function request(payload : axiosPayload) : Promise<AxiosResponse<any,any>> {
    const token:string|null = localStorage.getItem("authorizeToken");
    console.log(payload, '<< ini payload')
    const options = {
      method: payload.method,
      url: payload.url,
      params : payload.params,
      headers: {
        ...payload.config?.headers
      }
    }

    if (payload.isAuth) {
      options.headers = {
        ...options.headers,
        Authorization: `Bearer ${token}`,
      }
    }

    if (payload.data) {
      options.data = payload.data
    }

    return restAPI(options)

  }

  return {
    provide: {
      axios : request
    }
  };
});
