<template>
  <v-card class="px-5 py-5">
    <v-progress-circular v-if="loading" indeterminate color="primary" class="position-loader"/>
      <div v-else>
        <center>
          <p class="style-price"> 10x R$ {{product.without_fees}} </p>
          <p> {{ $t('option') }} </p>
          <p class="style-price"> 15x R$ {{ product.with_fees }} </p>

          <v-btn class="full-width primary">
            {{ $t('buy_message') }}
            <v-icon class="ml-5"> mdi-credit-card </v-icon>
          </v-btn>
        </center>
      </div>
  </v-card>
</template>

<script>
  export default {
     props: {
      loading: {
        required: true,
        type: Boolean
      },
      product: {
        required: true,
        type: Object
      }
    }
  }
</script>

<style scoped>
  .center-block{
    display: block !important;
    margin-left: auto !important;
    margin-right: auto !important;
  }

  .position-loader {
    display: block;
    margin: 125px auto 125px auto;
  }

  .style-price {
    font-size: 30px;
  }

  .full-width {
    width: 100%;
  }
</style>

