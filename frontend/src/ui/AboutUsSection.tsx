import Heading from "./Heading"
import Row from "./Row"
import Section from "./Section"


function AboutUsSection() {
  return (
    <Section>
        <Row as={'header'}>
          <Heading>
            Sobre <span>Nosotros</span>
          </Heading>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore
          </p>
        </Row>
    </Section>
  )
}

export default AboutUsSection