const express = require("express")
const jsonwebtoken = require("jsonwebtoken")

const app = express()

const JWT_SECRET = "ruweruidhwur238u40u4"

app.use(express.json())

const dataUsers = () => {
  return [
    { id: 1, email: "kemuel@gmail.com", password: 'senha1', document: 'xxx.xxx.xxx-xx' },
    { id: 2, email: "email2@gmail.com", password: 'senha2', document: 'xxx.xxx.xxx-xx' },
    { id: 3, email: "email3@gmail.com", password: 'senha3', document: 'xxx.xxx.xxx-xx' },
    { id: 4, email: "email4@gmail.com", password: 'senha4', document: 'xxx.xxx.xxx-xx' },
    { id: 5, email: "email5@gmail.com", password: 'senha5', document: 'xxx.xxx.xxx-xx' },
    { id: 6, email: "email6@gmail.com", password: 'senha6', document: 'xxx.xxx.xxx-xx' },
  ]
}

app.post('/login', (req, res) => {
  const { email, password } = req.body

  let userSelected = dataUsers().find((e) => e.email === email && e.password === password)

  userSelected = {...userSelected}

  if (Object.keys(userSelected).length === 0) {
    return res.status(401).json({
      message: 'User not exists, or your email or password is wrong'
    })
  }

  delete userSelected.document
  const jwtToken = jsonwebtoken.sign(userSelected, JWT_SECRET, {
    expiresIn: '1h'
  })

  res.status(201).json({
    message: 'Authentication is done with successfull',
    jwtToken,
  })
})

app.get('/document', (req, res) => {
  const { id } = req.query

  const userSelected = dataUsers().find((e) => e.id === id)

  if (!userSelected) {
    res.json({
      message: 'User not found'
    })
  }

  let authorization = req.headers.authorization

  if (!authorization) res.status(403).json({
    message: 'Your token is not valid'
  })

  authorization = authorization.split(" ")[1]

  jsonwebtoken.verify(authorization, JWT_SECRET, (error, user) => {
    if (error) res.status(403).json({ message: 'Your token is not valid' })

    const conditionOfId = user.id === userSelected.id
    const conditionOfEmail = user.email === userSelected.email
    const conditionPassword = user.password === userSelected.password

    const condition = conditionOfId && conditionOfEmail && conditionPassword

    if (!condition) {
      res.status(403).json({ message: 'Your email or password is wrong' })
    }
  })

  res.json({
    document: userSelected.document
  })
})

app.listen(3000, () => {
  console.log("App rodando na porta 3000")
})