import { plainAxiosInstance, securedAxiosInstance } from '@/packs/plugins/axios'

export default {
  list: ( id ) => plainAxiosInstance.get(`/api/v1/products/${id}`)
    .then((result) => {
      return result
    })
    .catch((err) => {
      return err.response
    }),
}