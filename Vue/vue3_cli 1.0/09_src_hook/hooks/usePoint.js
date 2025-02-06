import {onBeforeUnmount, onMounted, reactive} from "vue";

function usePoint() {
  const point = reactive({
    x: 0,
    y: 0
  })
  
  function getMousePosition(event) {
    point.x = event.pageX
    point.y = event.pageY
    
    console.log(event.pageX, event.pageY)
  }
  
  onMounted(() => {
    window.addEventListener('mousemove', getMousePosition)
  })
  
  onBeforeUnmount(() => {
    window.removeEventListener('mousemove', getMousePosition)
  })
  
  return point
}

export default usePoint