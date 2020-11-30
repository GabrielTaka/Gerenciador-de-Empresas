import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Formatter from './formatter'
import pt from './pt'
import en from './en'

Vue.use(VueI18n)

const locale = 'pt' // default locale
const formatter = new Formatter({ locale })

export default new VueI18n({
  locale,
  formatter,
  messages: {
    'en': en,
    'pt': pt
  }
})