<template>
  <div>
    <h1>{{ name }}</h1>
    <ul>
      <li v-for="foto of fotos" :key="foto.titulo">
        <img :src="foto.url" :alt="foto.titulo" />
      </li>
    </ul>
  </div>
  
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      name: 'Projeto AluraPicure',
      fotos: [
        {
          url: 'https://ichef.bbci.co.uk/news/410/cpsprodpb/6F51/production/_101779482_gettyimages-654134840.jpg',
          titulo: 'Foto 1'
        },
        {
          url: 'https://ichef.bbci.co.uk/news/410/cpsprodpb/6F51/production/_101779482_gettyimages-654134840.jpg',
          titulo: 'Foto 2'
        }
      ] 
    }
  }
}
</script>

<style>
</style>
