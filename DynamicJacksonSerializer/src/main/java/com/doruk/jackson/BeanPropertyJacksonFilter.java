package com.mudo.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

@SuppressWarnings("deprecation")
public class BeanPropertyJacksonFilter implements BeanPropertyFilter {

	private JacksonFilterContext context = new JacksonFilterContext();

	public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider prov, BeanPropertyWriter writer) throws Exception {
		String propertyName = writer.getName();
		if (context.isIncludedProperty(propertyName) || !context.isExcludedProperty(propertyName))
			writer.serializeAsField(bean, jgen, prov);
	}

	public void updateContext(JacksonFilter filter) {
		context.includeProperty(filter.includes());
		context.excludeProperty(filter.excludes());
	}

	public void clearContext() {
		setContext(new JacksonFilterContext());
	}

	public JacksonFilterContext getContext() {
		return context;
	}

	public void setContext(JacksonFilterContext context) {
		this.context = context;
	}

	public void depositSchemaProperty(BeanPropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider) throws JsonMappingException {
		
	}

	public void depositSchemaProperty(BeanPropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider) throws JsonMappingException {
		
	}
}