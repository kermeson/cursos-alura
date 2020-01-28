<template>
   <nav>
      <ul>
        <li v-for="route in routes" :key="route.path">
          <router-link :to="route.path">{{ route.titulo }}</router-link>
        </li>
      </ul>
    </nav>
</template>

<script>
export default {
    props: {
        routes: {
            required: true,
            type: Array
        }
    }
}
</script>

<style>

</style>