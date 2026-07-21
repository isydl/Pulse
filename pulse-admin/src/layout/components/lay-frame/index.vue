<script setup lang="ts">
import { type Component } from "vue";
import { type RouteLocationNormalizedLoaded } from "vue-router";

const props = defineProps<{
  currRoute: RouteLocationNormalizedLoaded;
  currComp: Component;
}>();
</script>
<template>
  <div class="w-full h-full">
    <slot :Comp="props.currComp" :fullPath="props.currRoute.fullPath" frameInfo />
  </div>
</template>
