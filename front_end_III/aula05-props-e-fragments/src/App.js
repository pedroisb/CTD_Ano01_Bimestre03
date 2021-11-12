import './App.css';
import Banner from './components/Banner';
import Footer from './components/Footer';
import Header from './components/Header';

function App() {
  return (
    <>
      <Header />
      <main>
        <Banner>
          <img src="https://cdn.hipwallpaper.com/i/47/1/kehZMf.jpg" alt="" />
          <button></button>
          <h1>TITULO</h1>
          <p>TEXTO</p>
        </Banner>
      </main>
      <Footer />
    </>
  );
}

export default App;
