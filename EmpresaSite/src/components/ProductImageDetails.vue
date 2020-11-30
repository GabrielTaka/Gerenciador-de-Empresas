<template>
  <v-card class="px-5 py-5">
    <v-progress-circular v-if="loading" indeterminate color="primary" class="position-loader"/>
    <div v-else>
      <v-img :src="product.big_avatar" class="image-show"/>
    </div>

    <h4 class="mt-4 mb-2"> {{product.name}} - {{product.short_description}} - {{product.quantity}} ML </h4>
    <div class="border-divider pt-5 grey-text">
    <h4> {{ $t('find_more') }} </h4>
      <p v-if="language"> {{product.description}} </p>
      <p v-else> {{product.description_eua}} </p>
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
    },
    computed: {
      language() {
        return this.$i18n.locale == 'pt' ? true : false
      }
    }
  }
</script>

<style scoped>
  .position-loader {
    display: block;
    margin: 200px auto 200px auto;
  }

  .border-divider {
    border-top: 2px solid rgb(155, 155, 155);
  }
  
  .grey-text {
    color: rgb(90, 90, 90);
  }

  .image-show {
    padding-bottom: 20px;
    width: 400px !important;
    height: 400px;
    display: block;
    margin-left: auto;
    margin-right: auto;
  }

  @media only screen and (max-width: 410px) {
    .image-show {
      width: 100% !important;
    }
  }
</style>