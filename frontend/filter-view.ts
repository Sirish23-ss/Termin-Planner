import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/date-picker/src/vaadin-date-picker.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/grid/src/vaadin-grid.js';

@customElement('filter-view')
export class FilterView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout>
  <vaadin-date-picker id="filterTermin" style="margin-left: var(--lumo-space-s);" label="Filter Termin" placeholder="Select Date"></vaadin-date-picker>
  <vaadin-button id="vaadinButton" style="align-self: flex-end; margin-left: var(--lumo-space-l);" tabindex="0">
    Search 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-grid id="grid"></vaadin-grid>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
