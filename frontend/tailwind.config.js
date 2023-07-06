/** @type {import('tailwindcss').Config} */
export default {
  mode: 'jit',
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}'
  ],
  theme: {
    extend: {

      fontFamily: {
        bebas: ['Bebas Neue', 'sans-serif'],
        workSans: ['Work Sans', 'sans-serif']
      }
    }
  },
  plugins: []
}
