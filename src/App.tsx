import { BrowserRouter, Routes, Route } from "react-router-dom"
import "./App.css"
import AdView from "./pages/view_ad/AdView"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* <Route path="/" element={<HomePage />} /> */}
        <Route path="/adview" element={<AdView />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
