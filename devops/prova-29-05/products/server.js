const express = require('express')

const app = express()

const PORT = 3001

app.use(express.json())

app.get('/products', (req, res) => {
  res.json({
    products: [
      { id: 1, name: 'Notebook', price: 3000 },
      { id: 2, name: 'Mouse', price: 100 },
    ]
  })
})

app.listen(PORT, () => {
  console.log(`Products API running on port ${PORT}`)
})