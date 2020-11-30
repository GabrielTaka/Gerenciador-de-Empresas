<template>
  <div id="app">
    <top-info-section />
    <v-container>
      <v-row>
        <v-col cols="12" sm="12" md="8">
          <product-image-details :loading="loading" :product="product"/>
        </v-col>
        <v-col cols="12" sm="12" md="4">
          <product-price-details :loading="loading" :product="product"/>
        </v-col>
      </v-row>
    </v-container>

    <footer-panel/>
  </div>
</template>

<script>
  import topInfoSection from "@/components/TopInfoSection"
  import productImageDetails from "@/components/ProductImageDetails"
  import productPriceDetails from "@/components/ProductPriceDetails"
  import footerPanel from "@/components/FooterPanel"
  import ProductsRepository from "@/repository/ProductsRepository"
  
  export default {
    components: { topInfoSection, productImageDetails, productPriceDetails, footerPanel },
    data() {
      return {
        product: {},
        id: null,
        loading: true
      }
    },
    
    created() {
      this.listProduct( this.$route.params.id )
    },

    methods: {
      async listProduct( id ) {
        let response = await ProductsRepository.list( id )
        if ( response.status == 200 ) {
          this.product = response.data 
          this.loading = false
        }
      }
    }
  }
</script>