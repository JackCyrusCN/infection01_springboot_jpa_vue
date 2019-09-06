<template>
  <div id="app">
    <h1>Stock Price</h1>
    <div>
      <ul>
        <li v-for="(m,key) in list1" :key="key">{{ m.name }}: {{ m.price }}</li>
      </ul>
    </div>
    <div>
      <ul>
        <li v-for="(m,key) in list2" :key="key">{{ m.name }}: {{ m.price }}</li>
      </ul>
    </div>
  </div>
</template>

<script>

export default {
  mounted: function () {
    this.$nextTick(function () {
      let socket = new SockJS('/test-info')
      stompClient = Stomp.over(socket)
      stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame)

        stompClient.subscribe('/stock/price', function (val) {
          console.log(val)
          console.log(JSON.parse(val.body))
          this.list1 = JSON.parse(val.body)
        })
      })

      let socket2 = new SockJS('/test-info')
      stompClient2 = Stomp.over(socket2)
      stompClient2.connect({}, function (frame) {
        console.log('Connected: ' + frame)

        stompClient2.subscribe('/stock/price-fast', function (val) {
          console.log(val)
          console.log(JSON.parse(val.body))
          this.list2 = JSON.parse(val.body)
        })
      })
    })
  },
  data: function () {
    return {
      message: 'Dynamic Content',
      list1: [],
      list2: []
    }
  }
}
</script>
