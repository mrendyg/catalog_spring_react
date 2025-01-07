
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'

import Layout from './components/Layout'
import LoginPage from './pages/LoginPage'


function App() {


  return (
    <BrowserRouter>

    
    <Routes>
      <Route path='/' element={<Layout />}>

        <Route path='/login' element={<LoginPage />}/>

      </Route>
    </Routes>

    </BrowserRouter>
  )
}

export default App