import { BrowserRouter, Routes, Route } from "react-router-dom"
import "./App.css"
import AdView from "./pages/AdView"
import InitialView from "./pages/InitialView/InitialView"

function App() {
  return (
   
    
    <BrowserRouter>
      <Routes>
       <Route path="/" element={<InitialView />} /> 
        <Route path="/adview" element={<AdView />} />
      </Routes>
    </BrowserRouter> 
  )
}

export default App
